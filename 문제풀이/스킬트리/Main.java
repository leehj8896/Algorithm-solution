class Solution {
    String skill;
    String[] skill_trees;

    public int solution(String skill, String[] skill_trees) {
        this.skill=skill;
        this.skill_trees=skill_trees;

        int cnt=0;
        for(String tree:skill_trees){

            int index=0;
            for(int i=0; i<tree.length(); i++){
                int k=getIndex(tree.charAt(i));
                if(k>index) break;
                else if(k==index) index++;
                if(i==tree.length()-1) cnt++;
            }
        }

        return cnt;
    }

    private int getIndex(char c) {

        for(int i=0; i<skill.length(); i++){
            if(skill.charAt(i)==c) return i;
        }

        return -1;
    }
}