import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Answer a=new Answer(files);
        answer=a.get();
        return answer;
    }
  }
class Answer{
    String[] fileStrs;
    int len;
    File[] fileObjects;
    public Answer(String[] files) {
        this.fileStrs=files;
        len=files.length;
        fileObjects = new File[len];
        initData();
    }

    private void initData() {
        for(int i=0; i<len; i++){
            int[] ends = getEnds(fileStrs[i]);
            fileObjects[i]= new File(
                fileStrs[i],
                fileStrs[i].substring(0,ends[0]).toLowerCase(),
                Integer.parseInt(fileStrs[i].substring(ends[0],ends[1]))
            );
            if(ends[1]<fileStrs[i].length())
                fileObjects[i].tail=fileStrs[i].substring(ends[1],fileStrs[i].length());
        }
    }

    private int[] getEnds(String str) {
        int[] indices={0,str.length()};
        for(int i=0; i<str.length(); i++){
            if(isNum(str.charAt(i))){
                indices[0]=i;
                break;
            }
        }

        for(int i=indices[0]; i<str.length(); i++){
            if(!isNum(str.charAt(i))){
                indices[1]=i;
                break;
            }
        }

        return indices;
    }

    private boolean isNum(char c) {
        if((int)c>=48&&(int)c<=57)
            return true;
        return false;
    }

    public String[] get() {
        
        Arrays.sort(fileObjects);

        for(int i=0; i<len; i++) fileStrs[i]=fileObjects[i].full;

        return fileStrs; 
    }

    private void printInts(int[] arr) {
        for(int i:arr) System.out.println(i);
    }

    private void printStrs(String[] strs) {
        for(String s:strs) System.out.println(s);
    }
}

class File implements Comparable<File>{
    String full, head, tail;
    int number;

    public File(String string, String lowerCase, int parseInt) {
        this.full=string;
        this.head=lowerCase;
        this.number=parseInt;
        this.tail="";
    }

    @Override
    public int compareTo(File f) {

        if(this.head.compareTo(f.head)>0){
            return 1;
        }else if(this.head.compareTo(f.head)<0){
            return -1;
        }else if(this.head.compareTo(f.head)==0){
            if(this.number > f.number) {
                return 1;
            }else if(this.number < f.number) {
                return -1;
            }else if(this.number == f.number) {
                return 0;
            }
        }
        return 0;
    }
}