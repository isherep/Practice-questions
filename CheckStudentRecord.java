public class CheckStudentRecord {
    public boolean checkRecord(String s) {
        if(s == null || s.length() < 1){
            return false;
        }
        int aCount = 0;
        int Lcount = 0;
        for(int i = 0; i< s.length(); i++){

            if(s.charAt(i) == 'A'){
                aCount ++;
                Lcount = 0;
            }
            if(s.charAt(i) == 'L'){
                Lcount++;
            }else {
                Lcount = 0;
            }

            if((aCount > 0 && Lcount > 2) || (aCount >1) || Lcount > 2){
                return false;
            }
        }
        return true;
    }
}
