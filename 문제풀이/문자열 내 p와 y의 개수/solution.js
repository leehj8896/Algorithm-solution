function solution(s){
    var answer = true;

    var lowered=s.toLowerCase();
    var parr=lowered.match(/p/g);
    var yarr=lowered.match(/y/g);

    if(!parr && !yarr)
    {
        return true;
    }
    else if(!parr || !yarr)
    {
        return false;
    }
    else
    {
        if(parr.length===yarr.length){
            return true;
        }else{
            return false;
        }
    }
}