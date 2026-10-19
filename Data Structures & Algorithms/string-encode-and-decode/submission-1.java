class Solution {
    String spilt_str = "|@|";
    public String encode(List<String> strs) {
        String combain = "";
        for (int i=0;i<strs.size();i++) {
            String temp = strs.get(i);
            combain = combain + temp+spilt_str;

        }
        String result=null;
        try{
            byte[] encode = Base64.getEncoder().encode(combain.getBytes("utf-8"));
            result = new String(encode);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<String> decode(String str) {
        byte[] decode = null;
        try{
             decode = Base64.getDecoder().decode(str.getBytes("utf-8"));
        }catch(Exception e){
            e.printStackTrace();
        }
        String result = new String(decode);
        List<String> list = new ArrayList<>();
        while(result.indexOf(spilt_str)!=-1){
            int i = result.indexOf(spilt_str);
            str = result.substring(0,i);
            result = result.substring(i+spilt_str.length(),result.length());
            list.add(str);
        }
        return list;
    }
}

