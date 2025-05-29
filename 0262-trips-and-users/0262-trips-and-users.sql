# Write your MySQL query statement below
WITH UnbannedUsers AS (
    SELECT users_id
    FROM Users
    WHERE banned = 'No'
),
FilteredTrips AS (
    SELECT T.request_at, T.status
    FROM Trips T
    JOIN UnbannedUsers C ON T.client_id = C.users_id
    JOIN UnbannedUsers D ON T.driver_id = D.users_id
    WHERE T.request_at BETWEEN '2013-10-01' AND '2013-10-03'
)
SELECT
    DISTINCT FT.request_at AS Day,
    ROUND(
        SUM(CASE WHEN FT.status IN ('cancelled_by_driver', 'cancelled_by_client') THEN 1 ELSE 0 END) * 1.0
        / COUNT(*),
        2
    ) AS `Cancellation Rate`
FROM FilteredTrips FT
GROUP BY FT.request_at
ORDER BY FT.request_at;