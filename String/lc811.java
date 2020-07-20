package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String>res=new ArrayList<>();
        HashMap<String,Integer>domainCount=new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String cur=cpdomains[i];
            int num=Integer.valueOf(cur.split(" ")[0]);
            String domainRest=cur.split(" ")[1];
            //正则表达式的转义字符
            String[] domains=domainRest.split("\\.");
            StringBuffer addStrBuffer=new StringBuffer();
            for (int j = domains.length-1; j >=0; j--) {
                if(j!=domains.length-1){
                    addStrBuffer.insert(0, ".");
                }
                addStrBuffer.insert(0, domains[j]);
                String insertStr=addStrBuffer.toString();
                if (domainCount.containsKey(insertStr)){
                    domainCount.replace(insertStr, domainCount.get(insertStr)+num);
                }
                else domainCount.put(insertStr, num);
            }

        }
        for (String domain:domainCount.keySet()){
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append(domainCount.get(domain));
            stringBuffer.append(" ");
            stringBuffer.append(domain);
            res.add(stringBuffer.toString());
        }
        return res;
    }

}
