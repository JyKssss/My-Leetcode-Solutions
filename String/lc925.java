package String;

public class lc925 {
    public boolean isLongPressedName(String name, String typed) {
        int i=0,j=0, nameLen=name.length(), typeLen=typed.length();
        char preT='.';
        if (name.length()>typed.length()){
            return false;
        }
        while (i<nameLen){
            char nCur=name.charAt(i);
            while (j<typeLen&&typed.charAt(j)!=nCur){
                if (typed.charAt(j)==preT){
                    j++;
                }
                else {
                    return false;
                }
            }
            if (j>=typeLen&&i<nameLen){
                return false;
            }
            preT=nCur;
            i++;
            j++;
        }
        while (j<typeLen){
            if (typed.charAt(j)!=preT){
                return false;
            }
            j++;
        }
        return true;
    }
}
