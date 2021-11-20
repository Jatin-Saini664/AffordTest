import java.util.HashMap;

interface ToyTCPStream{
    public void receive(int chunk, byte[] data);
    public int read(byte[] data);
}

public class Tcp implements ToyTCPStream{
    HashMap<Integer, String> map;

    Tcp(){
        map = new HashMap<>();
    }
    public void receive(int chunk, byte[] data){
        map.put(chunk-1, data.toString());
    }

    public int read(byte[] data){
        int i=1;
        while(map.containsKey(i-1)){
            String s = map.get(i-1);
            for(int j=0;j<s.length();j++){
                data[i-1+j]=(byte)(s.charAt(j));
            }
            i+=s.length();
        }
        return i-1;
    }
    public static void main(String args[]){

    }
}