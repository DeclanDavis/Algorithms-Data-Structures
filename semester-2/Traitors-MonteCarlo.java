public class Traitors-MonteCarlo {
    public static void main(String args[]) {

        double sim = 100000;
        double tWin = 0;
        
        for(int i = 0; i < sim; i++){
            int traitors = 3;
            int faithful = 22 -3;
            while (traitors+faithful>2){        
                boolean votingResult = voting(traitors, faithful, traitors, faithful);
                if(votingResult==false){
                    faithful--;
                } else {
                    traitors--;
                }
                //murder
                faithful--;
            }
            if(traitors>0){
                tWin++;
            }
        }
        System.out.println("Probability traitors win: " + tWin*100/sim);
    }
    
    public static boolean voting(int traitors, int faithful, int tVotes, int fVotes){
        
        int[] voting = new int[faithful+traitors];
        voting[0]=tVotes;
        
        for(int i=0; i<fVotes; i++){
            int random;
            do{
                random =(int)(Math.random()*voting.length);
            } while(random==i&&i<faithful);
            voting[random]++;
        }
        int findmax=0;
        for(int i=0; i<voting.length;i++){
            if(voting[i]>findmax){
                findmax=voting[i];
            }
        }
        int traitorsSelected=0;
        int faithfulSelected=0;
        
        for(int i = 0; i<faithful + traitors; i++){
            if(voting[i]==findmax){
                if(i<faithful){
                    faithfulSelected++;
                } else {
                    traitorsSelected++;
                }
            }
        } 
        
        if(traitorsSelected>0 && faithfulSelected==0){
            return true;
        }else if (faithfulSelected>0&&traitorsSelected==0){
            return false;
        } else {
            return voting(traitorsSelected, faithfulSelected, tVotes, fVotes);
        }    
    }
}
