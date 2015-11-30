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
   @Override
   private void dfs(int u, int[] parent, List<Integer> searchOrder,
      boolean[] isVisited) {
/*
     // The Old Recursive Code that is being overriden
     // Store the visited vertex
     searchOrder.add(u);
     isVisited[u] = true; // Vertex v visited

     for (Edge e : neighbors.get(u)) {
      if (!isVisited[e.v]) {
         parent[e.v] = u; // The parent of vertex e.v is u
         dfs(e.v, parent, searchOrder, isVisited); // Recursive search
      }//end if
   }//end for
*/
}//end dfs

}//end UnweightedGraphWithNonrecursiveDFS
