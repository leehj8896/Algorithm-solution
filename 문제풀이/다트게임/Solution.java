class Solution {
    public static int solution(String dartResult) {
        int answer = 0;

        String[] score = {"", "", ""};

        int i = 0;  int j = 0;
        while(i<dartResult.length()){
            //S, D, T
            if(
                dartResult.substring(i, i+1).equals("S")||
                dartResult.substring(i, i+1).equals("D")||
                dartResult.substring(i, i+1).equals("T")
            ){
                score[j] += dartResult.substring(i, i+1);

                //옵션
                if(
                    i+1 < dartResult.length() &&
                    (dartResult.substring(i+1, i+2).equals("*")||
                    dartResult.substring(i+1, i+2).equals("#"))
                ){
                    score[j] += dartResult.substring(i+1, i+2);
                    i++;
                }
                j++;
            //점수
            }else{
                score[j] += dartResult.substring(i, i+1);
            }
            i++;
        }

        System.out.println(score[0]);
        System.out.println(score[1]);
        System.out.println(score[2]);

        int aaa[] = {0,0,0};
        String bbb[] = {"","",""};
        String ccc[] = {"","",""};
        for(int k = 0; k < 3; k++){
            //10이면
            if(score[k].substring(1, 2).equals("0")){
                aaa[k]=Integer.parseInt(score[k].substring(0, 2));
                bbb[k]=score[k].substring(2, 3);
                if(score[k].length() == 4)
                    ccc[k] = score[k].substring(3,4);

            //10이 아니면
            }else{
                aaa[k]=Integer.parseInt(score[k].substring(0, 1));
                bbb[k]=score[k].substring(1, 2);
                if(score[k].length() == 3)
                    ccc[k] = score[k].substring(2,3);
            }
        }
        for(int p = 0; p < 3; p++){
            if(bbb[p].charAt(0) == 'D')
                aaa[p] =aaa[p]*aaa[p];
            if(bbb[p].charAt(0) == 'T')
                aaa[p] =aaa[p]*aaa[p]*aaa[p];
        }
        for(int k = 0; k < 3; k++){
            if(ccc[k].equals(""))
                continue;
            if(ccc[k].substring(0,1).equals("*")){
                if(k == 0)
                    aaa[k] *= 2;
                else{
                    aaa[k]*=2;
                    aaa[k-1]*=2;
                }            }                
            if(ccc[k].substring(0,1).equals("#"))
                aaa[k] = -1 * aaa[k];
        }
        System.out.println(aaa[0]);
        System.out.println(aaa[1]);
        System.out.println(aaa[2]);
        answer = aaa[0]+aaa[1]+aaa[2];
        return answer;
    }

    public static void main(String[] args){

        String dartResult="1S*2T*3S";
        System.out.println(solution(dartResult));
    }
  }