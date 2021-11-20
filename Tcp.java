import java.util.HashMap;
import java.nio.charset.StandardCharsets;

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
        String s = new String(data, StandardCharsets.UTF_8);
        map.put(chunk-1, s);
    }

    public int read(byte[] data){
        int i=1;
        while(map.containsKey(i-1)){
            String s = map.get(i-1);
            for(int j=0;j<s.length();j++){
                data[i-1+j]=(byte)(s.charAt(j));
            }
            i+=s.length()-1;
        }
        return i-1;
    }
    public static void main(String args[]){
        String s = "I ";
        byte[] arr = s.getBytes();

        Tcp a = new Tcp();
        a.receive(1, arr);
        byte[] ab = new byte[10];
        System.out.println(a.read(ab));
    }
}