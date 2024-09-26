class MyCalendar {

    private List<int[]> bookings;

    
    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        
        for (int[] event : bookings) {
            int bookedStart = event[0];
            int bookedEnd = event[1];
            
           
            if (start < bookedEnd && end > bookedStart) {
                return false;
            }
        }
        
       
        bookings.add(new int[]{start, end});
        return true;
    }
}
