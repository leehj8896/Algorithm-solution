import java.util.HashMap;

class Solution {
    public static String[] solution(String[] record) {
        String[] answer = {};
        Answer a = new Answer(record);
        answer = a.getAnswer();
        return answer;
    }
    public static void main(String[] args) {
        String[] record = {
            "Enter uid1234 Muzi", 
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        printStrs(solution(record));
    }

    private static void printStrs(String[] solution) {
        for(String s:solution)
            System.out.print(s+" ");
        System.out.println();
    }
}

class Answer{
    String[] record;
    HashMap<String, String> hashMap;

    public Answer(String[] record) {
        this.record=record;
    }

    public String[] getAnswer() {
        hashMap = new HashMap<>();
        int numChage = 0;   int len = record.length;
        for(String str: record){
            String[] list = str.split(" ");
            if(list[0].equals("Change")){
                numChage++;
                hashMap.put(list[1], list[2]);
            }
            else if(list[0].equals("Enter")){
                hashMap.put(list[1], list[2]);
            }
        }

        String[] answer = new String[len-numChage];
        int j=0;
        for(int i=0;i<len-numChage;){
            String[] list = record[j].split(" ");
            if(list[0].equals("Enter")){
                answer[i] = hashMap.get(list[1]);
                answer[i] += "님이 들어왔습니다.";
                i++;j++;
            }else if(list[0].equals("Leave")){
                answer[i] = hashMap.get(list[1]);
                answer[i] += "님이 나갔습니다.";
                i++;j++;
            }else{
                j++;
            }
        }
        return answer;
    }
}