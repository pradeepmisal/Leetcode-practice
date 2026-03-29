from flask import Flask, request, jsonify
import json
import numpy as np

app = Flask(__name__)


def monte_carlo_simulation(portfolio_data, scenario_data, num_simulations=10000):
    """
    Performs a Monte Carlo simulation on a portfolio based on market scenarios.
    """
    portfolio = portfolio_data
    scenarios = scenario_data["market_scenarios"]

    results = {}

    for scenario_key, scenario_details in scenarios.items():
        scenario_name = scenario_details["name"]
        sector_impacts = scenario_details.get("sector_impact", {})
        results[scenario_name] = {
            "average_return": 0,
            "std_dev_return": 0,
            "percentiles": {},
        }

        portfolio_values = []
        for _ in range(num_simulations):
            portfolio_value = 0
            for asset_name, asset_details in portfolio["assets"].items():
                sector = asset_details["sector"]
                quantity = asset_details["quantity"]
                initial_price = asset_details["initial_price"]

                price_change_percentage = 0
                if sector in sector_impacts:
                    price_change_percentage = np.random.normal(
                        loc=sector_impacts[sector] / 100, scale=0.1
                    )

                new_price = initial_price * (1 + price_change_percentage)
                portfolio_value += new_price * quantity
            portfolio_values.append(portfolio_value)

        initial_portfolio_value = sum(
            asset["quantity"] * asset["initial_price"]
            for asset in portfolio["assets"].values()
        )
        returns = [
            (value - initial_portfolio_value) / initial_portfolio_value
            for value in portfolio_values
        ]

        results[scenario_name]["average_return"] = round(float(np.mean(returns)), 6)
        results[scenario_name]["std_dev_return"] = round(float(np.std(returns)), 6)
        results[scenario_name]["percentiles"] = {
            "p5": round(float(np.percentile(returns, 5)), 6),
            "p25": round(float(np.percentile(returns, 25)), 6),
            "p50": round(float(np.percentile(returns, 50)), 6),
            "p75": round(float(np.percentile(returns, 75)), 6),
            "p95": round(float(np.percentile(returns, 95)), 6),
        }

    return results


@app.route("/", methods=["GET"])
def index():
    return jsonify({
        "message": "Monte Carlo Portfolio Simulation API",
        "endpoints": {
            "GET /": "API info",
            "POST /simulate": "Run Monte Carlo simulation",
            "GET /sample-portfolio": "Get sample portfolio data",
            "GET /sample-scenarios": "Get sample scenario data",
        },
    })


@app.route("/simulate", methods=["POST"])
def simulate():
    data = request.get_json()
    if not data:
        return jsonify({"error": "No JSON data provided"}), 400

    portfolio_data = data.get("portfolio")
    scenario_data = data.get("scenarios")
    num_simulations = data.get("num_simulations", 10000)

    if not portfolio_data or not scenario_data:
        return jsonify({"error": "Both 'portfolio' and 'scenarios' fields are required"}), 400

    try:
        results = monte_carlo_simulation(portfolio_data, scenario_data, num_simulations)
        return jsonify({"status": "success", "results": results})
    except Exception as e:
        return jsonify({"error": str(e)}), 500


@app.route("/sample-portfolio", methods=["GET"])
def sample_portfolio():
    try:
        with open("portfolio.json") as f:
            return jsonify(json.load(f))
    except (FileNotFoundError, json.JSONDecodeError) as e:
        return jsonify({"error": str(e)}), 500


@app.route("/sample-scenarios", methods=["GET"])
def sample_scenarios():
    try:
        with open("scenarios.json") as f:
            return jsonify(json.load(f))
    except (FileNotFoundError, json.JSONDecodeError) as e:
        return jsonify({"error": str(e)}), 500


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
