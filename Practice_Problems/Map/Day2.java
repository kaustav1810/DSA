// link: https://leetcode.com/problems/design-underground-system/

class UndergroundSystem {
    
    Map<Integer,Map<String,Integer>> inDetails;
    
    Map<Map<String,String>,double[]> avgTime;
    
    
    public UndergroundSystem() {
        this.inDetails = new HashMap<>();
        this.avgTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        Map<String,Integer> map = new HashMap<>();
        
        map.put(stationName,t);
        
        this.inDetails.put(id,map);
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        
        Map<String,Integer> inTimes = this.inDetails.get(id);
        
        String startPlace = String.valueOf(inTimes.keySet().toArray()[0]);
        
        Integer startTime = inTimes.get(startPlace);
        
        Integer travelTime = t-startTime;
        
        Map<String,String> temp = new HashMap<>();
        
        temp.put(startPlace,stationName);
        
        double sum = 0,count = 0;
        
        if(!this.avgTime.containsKey(temp)){
            sum = count = 0;
        }
        
        else{
            sum = (int)avgTime.get(temp)[0];
            count = (int)avgTime.get(temp)[1];
        }
        
        sum += travelTime;
        count++;
        
        double[] arr = new double[]{sum,count};
        
        avgTime.put(temp,arr);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        for(Map.Entry<Map<String,String>,double[]> entry:avgTime.entrySet()){
            
            String startPlace = String.valueOf(entry.getKey().keySet().toArray()[0]);
            String endPlace = String.valueOf(entry.getKey().values().toArray()[0]);
            
            if(startPlace.equals(startStation) && endPlace.equals(endStation)){
                
                double totalTime = entry.getValue()[0];
                double count = entry.getValue()[1];
                
                return (totalTime/count);
            }
        }
        
        return 1;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
