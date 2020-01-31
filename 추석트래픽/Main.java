class Main{
    public static void main(String[] args) {
        String[] lines= {
            "2016-09-15 01:00:04.002 2.0s",
            "2016-09-15 01:00:07.000 2s"
            };
        Solution s=new Solution();
        System.out.println(s.solution(lines));
    }
}

class Solution {
    String[] lines;
    Section[] sections;
    public int solution(String[] lines) {
        this.lines=lines;
        initData();

        int maxValue=0;
        for(Section s:sections){
            int num=check(s);
            if(maxValue<num) maxValue=num;
        }

        return maxValue;
    }

    private int check(Section section) {

        int startCount=0, endCount=0;
        for(Section s:sections){
            if(!(((s.start > section.start)||(s.end < section.start-999)))){
                startCount++;
            }
            if(!((section.end-999 < s.start)||(section.end > s.end))){
                endCount++;
            }
        }
        if(startCount <= endCount) return endCount;
        return startCount;
    }

    private void initData() {
        sections = new Section[lines.length];
        for(int i=0;i<lines.length;i++){
            sections[i]=new Section(lines[i]);
        }
    }
}

class Section{
    int start, end;

    public Section(String line) {
        String[] tmp1 = line.split(" ");
        String[] tmp2 = tmp1[1].split(":");
        int h = Integer.parseInt(tmp2[0]);
        int m = Integer.parseInt(tmp2[1]);
        double s = Double.parseDouble(tmp2[2]);
        double time = Double.parseDouble(tmp1[2].substring(0,tmp1[2].length()-1));
        end=h*60; end+=m; end*=60; end*=1000; end+= (int)(s*1000);
        start=end-(int)(time*1000)+1;
        // System.out.println(start+" "+end);
    }
}