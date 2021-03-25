package Search;

public class lc777 {
    /**
     * L只能向左移动  R只能向右移动 LR不能交换相对位置
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        if (start.length()!=end.length()){
            return false;
        }
        int i=0,j=0, length=start.length();
        while (i<length&&j<length){
            while (i<length&&start.charAt(i)=='X'){
                i++;
            }

            while (j<length&&end.charAt(j)=='X'){
                j++;
            }


            if ((i==length&&j<length)||(j==length&&i<length)){
                return false;
            }
            if (i<length&&j<length&&start.charAt(i)!=end.charAt(j)){
                return false;
            }

            if (i<length&&start.charAt(i)=='L' && i<j){
                return false;
            }

            if (i<length&&start.charAt(i)=='R' && i>j){
                return false;
            }

            i++;
            j++;
        }

        while (i<length){
            if (start.charAt(i)!='X'){
                return false;
            }
            i++;
        }

        while (j<length){
            if (end.charAt(j)!='X'){
                return false;
            }
            j++;
        }

        return true;

    }
}
