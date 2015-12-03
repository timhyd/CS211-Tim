public class UnweightedGraphWithNonrecursiveDFS extends UnweightedGraph{
/*

DFS-A(G,s)
for all v in V[G] do
   visited[v] := false
end for
S := EmptyStack
Push(S,s)
while not Empty(S) do
   u := Pop(S)
   if not visited[u] then
      visted[u] := true
      for all w in Adj[u] do
         if not visited[w] then
            Push(S,w)
         end if
      end for
   end if
end while

*/
//Complier is rejecting Override of dfs class. IDKY but it does. 
   //@Override
   private void dfsnewclass(int u, int[] parent, java.util.List<Integer> searchOrder,
      boolean[] isVisited) {

     // Store the visited vertex
     searchOrder.add(u);
     isVisited[u] = true; // Vertex v visited
     java.util.LinkedList<Integer> queue = new java.util.LinkedList<>(); // list used as a queue
while (!queue.isEmpty()) {
    searchOrder.add(u); // u searched
     for (Edge e : neighbors.get(u)) {
      if (!isVisited[e.v]) {
         queue.offer(e.v); // Enqueue w
         parent[e.v] = u; // The parent of w is u
         isVisited[e.v] = true; // Mark it visited
      }//end if
   }//end for
}
}//end dfs

}//end UnweightedGraphWithNonrecursiveDFS
