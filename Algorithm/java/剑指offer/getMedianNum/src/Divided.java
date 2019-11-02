import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divided {

    public static void main(String[] args) {

    }

    public void devided(int a[],int b[]){
        ArrayList arrayList = new ArrayList(Arrays.asList(a));
        arrayList.addAll((Arrays.asList(b)));
        Object c[]=arrayList.toArray();
        Arrays.sort(c);




    }
}
