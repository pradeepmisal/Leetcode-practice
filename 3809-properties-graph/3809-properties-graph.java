class Solution {
    Map<Integer,List<Integer>> graph = new HashMap<>();
    public int numberOfComponents(int[][] properties, int k) {
        int v = properties.length;
        for(int i = 0 ; i < v; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i = 0 ; i < v; i++){
            for(int j = 0; j < v; j++){
                if(i != j && checkIntersection(properties[i],properties[j],k)){
                    addEdge(graph,i,j);
                }
            }
        }
        int cc = connectedComponent(graph, v);
        System.out.println(cc);
        return cc;
    }
    public boolean checkIntersection(int arr1[], int arr2[], int k){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                set.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }else{
                i++;
            }
        }
        if(set.size() >= k){
            return true;
        }
        return false;
    }
    public void addEdge(Map<Integer,List<Integer>> graph, int v1, int v2){
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }
    public int connectedComponent(Map<Integer,List<Integer>> graph,int v) {
        
        int visited[] = new int[v];

        int count = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 0){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }
    public void dfs(Map<Integer,List<Integer>> graph, int []visited,int src){
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(visited[v] == 1){
                continue;
            }
            visited[v] = 1;
            for(int nbrs : graph.get(v)){
                if(visited[nbrs] != 1){
                    stack.push(nbrs);
                }
            }
        }

    }
    
}