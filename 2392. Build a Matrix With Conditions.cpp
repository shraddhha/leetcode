class Solution {
public:
    bool toposort(int n,unordered_map<int,pair<int,int>> &map,vector<int> adj[],int idx,int curr){
        queue<int> q;
        vector<int> indegree(n+1,0);
        for(int i=1;i<=n;i++){
            for(auto it:adj[i]){
                indegree[it]++;
            }
        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==0)q.push(i);
        }
        int cnt=0;
        while(!q.empty()){
            int node=q.front();q.pop();
            cnt++;
            //topo.push_back(node);
            int x=map[node].first, y=map[node].second;
            if(curr==1){
                map[node].first=idx++;
            }
            else{
                map[node].second=idx++;
            }
            for(auto it:adj[node]){
                indegree[it]--;
                if(indegree[it]==0){
                    q.push(it);
                }
            }
        }
        if(cnt==n)return true;
        return false;
    }
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& r, vector<vector<int>>& c) {
        //topological sort by kahn's algorithm
        vector<vector<int>> mat(k,vector<int> (k,0)),ans;
        vector<int> adj[k+1],adj1[k+1];
        for(auto it:r){
            adj[it[0]].push_back(it[1]);
        }
        //vector<int> topoR,topoC;
        unordered_map<int,pair<int,int>> map;
        for(int i=1;i<=k;i++)map.insert({i,{-1,-1}});
        if(toposort(k,map,adj,0,1)==false){
            cout<<1;
            return ans;
        }
        for(auto it:c){
            adj1[it[0]].push_back(it[1]);
        }
        if(toposort(k,map,adj1,0,2)==false){
            cout<<2;
            return ans;
        }
        for(auto it:map){
            int node=it.first;
            int x=it.second.first, y=it.second.second;
            if(x>=0 && y>=0)mat[x][y]=node;
        }
        
        return mat;
    }
};
