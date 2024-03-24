package LeetCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MSFTE {
    public static void main(String[] args) {
        List<User> realUser=new ArrayList<>();
        List<User> newList=new ArrayList<>();
        realUser.add(new User(1,"abc","ind"));
        realUser.add(new User(2,"def","usa"));
        newList.add(new User(1,"ccc","ind"));
        newList.add(new User(0,"lll","afg"));
        newList.add(new User(2,"def","usa"));

        List<User>[] ans=getUpdatedAndInsertedLists(realUser,newList);
        System.out.println(ans[0].size()+" updated");
        System.out.println(ans[1].size()+" inserted");
        System.out.println(realUser.get(1).equals(newList.get(2)));
    }

    static class  User{
        int id;
        String name;
        String country;
        User(int id,String name,String country){
            this.id=id;
            this.name=name;
            this.country=country;
        }

    }
    public static List<User>[] getUpdatedAndInsertedLists(List<User> realList,List<User> newList){
        Map<Integer,User> map=new HashMap<>();
        List<User> updated=new ArrayList<>();
        List<User> inserted=new ArrayList<>();
        List<User>[] ans=new List[2];
        ans[0]=updated;
        ans[1]=inserted;
        for(int i=0;i<realList.size();i++){
            map.put(realList.get(i).id,realList.get(i));
        }

        for(int i=0;i< newList.size();i++){
            User user=newList.get(i);
            int id=user.id;
            if(id==0){
                inserted.add(user);
                map.put(id,user);
            }else{
                User u=map.get(id);
                if(map.containsKey(id) && !(compareObjects(user,u))) {
                    updated.remove(map.get(id));

                    updated.add(user);
                    map.put(id,user);
                }
            }
        }

        return ans;
    }

    private static boolean compareObjects(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null || obj1.getClass() != obj2.getClass())
            return false;
        try {
            for (Field field : obj1.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value1 = field.get(obj1);
                Object value2 = field.get(obj2);
                if (value1 == null && value2 != null || value1 != null && !value1.equals(value2)) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
