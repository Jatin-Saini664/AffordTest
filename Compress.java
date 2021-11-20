interface Codec{
    public CompressedData compress(String data);
    public String decompress(CompressedData data);
}

class CompressedData{

}


public class Compress implements Codec{
    public CompressedData compress(String data){
        return new CompressedData();
    }

    public String decompress(CompressedData data){
        return "";
    }
    public static void main(String args[]){

    }
}
