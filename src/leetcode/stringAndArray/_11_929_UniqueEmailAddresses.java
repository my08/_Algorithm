package leetcode.stringAndArray;

import java.util.HashSet;
import java.util.Set;

public class _11_929_UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {


        Set<String> set = new HashSet<>();
        //1. local,domain 따로 처리
//      Runtime: 31 ms, faster than 20.13% of Java online submissions for Unique Email Addresses.
//      Memory Usage: 52.3 MB, less than 5.00% of Java online submissions for Unique Email Addresses.
        for(String email: emails){
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);

            set.add(localName+"@"+domainName);
        }
        //2. replace, split, StringBuilder
//      Runtime: 13 ms, faster than 68.27% of Java online submissions for Unique Email Addresses.
//      Memory Usage: 38.8 MB, less than 98.25% of Java online submissions for Unique Email Addresses.

        /*for(String e : emails) {
            StringBuilder s = new StringBuilder();
            s.append(e.split("@")[0].replace(".", "").split("\\+")[0])
                    .append("@")
                    .append(e.split("@")[1]);
            set.add(s.toString());
        }*/
        return set.size();
    }

    private static String makeDomainName(String email) {
        return email.substring(email.indexOf('@')+1);
    }

    private static String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<email.length(); i++){
            //1. Error Check Conditions
            if(email.charAt(i) == '.'){
                continue;
            }
            if(email.charAt(i) == '+'){
                break;
            }

            //2.
            String str = String.valueOf(email.charAt(i));
            sb.append(str);

        }
        return sb.toString();
    }


}
