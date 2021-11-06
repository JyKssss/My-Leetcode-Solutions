package String;

import java.util.HashSet;

public class lc929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(parseEmail(email));
        }
        return emailSet.size();
    }

    private String parseEmail(String email){
        String[] emailList = email.split("@");
        String start = emailList[0];
        start = start.split("\\+")[0];
        String[] startList = start.split("\\.");
        StringBuffer res = new StringBuffer();
        for (String s : startList) {
            res.append(s);
        }

        return res.toString()+"@"+emailList[1];
    }
}
