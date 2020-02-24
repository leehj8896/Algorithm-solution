import java.util.Arrays;

class Solution {
    Page[] pageArr;
    
    public int solution(String word, String[] pages) {

        pageArr = new Page[pages.length];
        for(int i=0; i<pages.length; i++){
            Page p = new Page(i, pages[i], word);
            pageArr[i] = p;
        }

        setMatchingScores();

        Arrays.sort(pageArr);

        return pageArr[0].index;
    }

    private void printScore(Page[] pageArr) {
        for(Page p:pageArr) System.out.print(p.basicScore+" ");
        System.out.println();
    }

    private void setMatchingScores() {

        for(int i=0; i<pageArr.length; i++){
            pageArr[i].linkScore = getLinkScore(i);
            pageArr[i].matchingScore = pageArr[i].basicScore + pageArr[i].linkScore;
        }
    }

    private double getLinkScore(int index) {

        double sum=0;
        for(int i=0; i<pageArr.length; i++){
            if(containsLink(i, pageArr[index].url)){
                sum+= (double) pageArr[i].basicScore / pageArr[i].linkNum;
            }
        }
        return sum;
    }

    private boolean containsLink(int index, String url) {

        String[] aTags = pageArr[index].html.split("<a href=\"");
        if(aTags.length == 0) return false;

        for(int i=1; i<aTags.length; i++){
            String _url=aTags[i].split("\"")[0];
            if(_url.equals(url)) return true;
        }
        return false;
    }
}

class Page implements Comparable<Page>{

    String url, html;
    int index, linkNum;
    int basicScore;
    double linkScore, matchingScore;

    public Page(int index, String html, String word) {
        this.index=index;
        this.html=html;
        url=""; linkNum=0; basicScore=0; linkScore=0; matchingScore=0;
        setUrl();
        setLinkNum();
        setBasicScore(word);
    }

    private void setBasicScore(String word) {
        word=word.toLowerCase();
        String body = getBody();
        int count=0;
        int start = getStart(body, 0);
        while(true){
            if(start>=body.length()) break;
            
            int end=getEnd(body, start);
            String _word = body.substring(start, end).toLowerCase();
            if(_word.equals(word)) count++;
            start=getStart(body, end);
        }
        basicScore=count;
    }

    private String getBody() {
        String[] tmp = html.split("<body>");
        return tmp[1].split("</body>")[0];
    }

    private int getStart(String body, int end) {

        for(int i=end; i<body.length(); i++){
            if(isAlphabet(body.charAt(i))) return i;
        }
        return body.length();
    }

    private int getEnd(String body, int start) {

        for(int i=start; i<body.length(); i++){
            if(!isAlphabet(body.charAt(i))) return i;
        }
        return body.length();
    }

    private boolean isAlphabet(char c) {
        int tmp = (int)c;
        if(65<=tmp&&tmp<=90) return true;
        if(97<=tmp&&tmp<=122) return true;
        return false;
    }

    private void setLinkNum() {
        String body = getBody();
        String[] tmp = body.split("<a href=\"");
        linkNum=tmp.length-1;
    }

    private void setUrl() {
        String[] metas = html.split("<meta");

        for(int i=1; i<metas.length; i++){

            String[] closed = metas[i].split("/>");
            if(closed[0].contains("https")){
                String[] tmp1 = closed[0].split("content=\"");
                String[] tmp2 = tmp1[1].split("\"");
                url = tmp2[0];
            }
        }
    }

    @Override
    public int compareTo(Page p) {

        if(this.matchingScore!=p.matchingScore){

            double tmp = p.matchingScore-this.matchingScore;
            if(tmp>0) return 1;
            else return -1;
        }else{
            return this.index-p.index;
        }
    }
}