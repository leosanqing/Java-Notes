package com.leosanqing.hashMap;

import java.util.Map;
import java.util.Objects;

public class MyHashMap {

    // 初始默认的数组容量
    static final int INIT_CAPACITY = 1<<4;
    //数组最大的容量,因为 数组设置为 2的整次方倍，而 31 次方为负数，所以最大只能为 1 << 30
    static final int MAX_CAPACITY = 1<<30;
    // 默认的装填因子
    static final float DEFAULT_LOADFACTOR = 0.75f;


    /**
     * Entry 类 为map中基本的单元
     *
     * key 为键，value 为值
     * next 是在哈希冲突时，指向的下一个 Entry
     * h 为传入的hash值
     */
    static class Entry{
        Object key;
        private Object value;
        private Entry next;
        int h;

        public Entry(int h,Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.h = h;
        }

        public Entry() {

        }

        public Object getKey() {
            return key;
        }


        public Object getValue() {
            return value;
        }

        public Object setValue(Object newValue) {
            Object oldValue=value;
            this.value = newValue;
            return oldValue;

        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public  final int hashcode(){
            return Objects.hashCode(key)^Objects.hashCode(value);
        }

    }


    // 返回 hash值 ，如果 key 为 null，返回 0
    // 重新计算的哈希值为  原来的hashCode 和 高八位进行相与，
    // 这样做的好处： 如果不这样，当数组较短的时候，只能有低位进行运算，高位无效，分布不均

    static final int hash(Object key){
        int h;
        return (key==null) ? 0 : (h=key.hashCode())^(h >>> 16);
    }


    // 数组长度，通过这个运算得到
    // 扩容后的大小总是 2的 n 次方倍，且是离未扩容前的数字最近的那个 2的n次方
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }



    Entry[] table;

    // table 桶中的个数--数组的大小;
    int size;


    // 修改次数
    int modCount;

    // 扩容的阈值, capacity * load factor
    int threshold;

    // 装填因子
    float loadFactor;

    public MyHashMap(int initCapacity,float loadFactor) {
        if(initCapacity<0)
            throw new IllegalArgumentException("初始化容量失败: "+
                                                    initCapacity);
        if(initCapacity>= MAX_CAPACITY)
            initCapacity= MAX_CAPACITY;
        if(loadFactor<=0||Float.isNaN(loadFactor))
            throw new IllegalArgumentException("装填因子不合法"+
                                                    loadFactor);
        this.loadFactor=loadFactor;
        this.threshold=tableSizeFor(initCapacity);

    }

    /**
     * 只传入数组容量大小的
     * @param initCapacity
     */
    public MyHashMap(int initCapacity) {
        this(initCapacity,DEFAULT_LOADFACTOR);
    }

    /**
     * 无参的，全部默认
     */
    public MyHashMap() {
        this.loadFactor=DEFAULT_LOADFACTOR;
    }


    public MyHashMap(Map m){
        this.loadFactor=DEFAULT_LOADFACTOR;

    }

    /**
     * 当key是Map的时候才调用
     * @param m
     * @param evict
     */

    final void putEntries(Map m,boolean evict){
        int s=m.size();
        if(s>0){
            if(table==null){
                float ft=(float) s/loadFactor+1.0f;

                int t=(ft<(float) MAX_CAPACITY)?(int)ft: MAX_CAPACITY;

                // 如果 原来的 hashmap的 table 的大小为0（第一次添加数字）；
                // 那么就将他按照现在的 添加的table 大小进行扩容
                if(t>threshold){
                    threshold=tableSizeFor(t);
                }


            }
            // 如果添加的 entries 的 table 大小大于 阈值，就扩容
            else if(s>threshold){
                resize();
            }

            // 把各个 Entry 放入到 map中
            for( Object e :  m.entrySet()){

                Object key = ((Map.Entry) e).getKey();
                Object value = ((Map.Entry) e).getValue();
                putVal(hash(key),key,value,false,evict);
            }
        }
    }


    /**
     * 存放单个元素时调用
     */

    public Object put(Object key,Object value){
        return putVal(hash(key),key,value,false,true);
    }

    /**
     * 存放单个元素的操作
     * @param hash 哈希值，由key的高16位和低16位异或得到
     * @param key 键
     * @param value 值
     * @param onlyIfAbsent
     * @param evict
     * @return
     */
    private Object putVal(int hash, Object key, Object value, boolean onlyIfAbsent, boolean evict) {
            Entry[] tab;
            Entry p;
        int n,i;
        // 如果第一次 进行存放数据，进行初始化，table 被延迟到进行数据存放时才初始化
        if((tab = table) == null || (n = table.length)==0){
            n = (tab = resize()).length;
        }
        // 如果table 索引上没有存放元素
        if((p = table[i = ((n - 1) & hash)]) == null){
            tab[i] = newEntry(hash,key,value,null);
        }

        else {
            Entry e;
            Object k;
            // 如果 key 相同，那么就直接将 value 覆盖
            // 为什么要比较这么多次

            // 1.首先判断 哈希值是否相同
            if(p.h == hash &&
                    // 2.判断两个key是否相等，使用 '==' 是非字符串情况，之比较两个的内容，使用'equals' 是针对字符串
                    (((k = p.key) == key) || (key != null && key.equals(k))))
                // 覆盖value值
                e = p;

            // 这个是树的情况
            //else if(p instance of TreeNode)

            // 链
            else{
                for(int binCount=0;;++binCount){
                    // 遍历到最后，插入
                    if((e = p.next) == null){
                        p.next = newEntry(hash,key,value,null);

                        /*
                          如果 binCount > 转化树的阈值 ,则将链表转化为树

                        if(binCount >= TREEIFY_THRESHOLD-1)
                            treeifyBin(tab,hash);

                        */
                        break;
                    }
                    if(p.h == hash &&
                            (((k = p.key) == key) || (key != null && key.equals(k))))
                        break;
                    // 移动到下一个
                    p = e;
                }



                // 如果有相应的映射
                if(e != null){
                     Object oldValue = e.value;
                     if(!onlyIfAbsent || oldValue == null)
                         e.value = value;
                     return oldValue;
                }

            }



        }
        // 修改次数 ++
        ++ modCount;

        // 大于阈值就扩容
        if(++size >threshold)
            resize();

        // 插入元素
        //afterNodeInsertion(evict);

        return null;

    }



    public Object get(Object key){
        Entry e;

        return (e = getNode(hash(key),key)) == null ? null : e.value;

    }

    /**
     * 查找键值对
     * @param hash
     * @param key
     * @return 查找的元素或者 null
     */

    private Entry getNode(int hash, Object key) {
        Entry[] tab;
        Entry first,e;
        int n;
        Object k;

        if((tab=table) != null && (n=tab.length) >0 &&
                (first = tab[(n-1) & hash]) !=null){

            // 检查链表中的第一个
            if (first.h == hash &&
                    (((k = first.key) == key ) || (key !=null && key.equals(k)))){
                return first;
            }
            if ((e = first.next) != null){
                // 判断是否为树形结构
                // if (e instanceof TreeNode)
                // 然后调用 TreeNode的搜索方法

                //这个是在链表中查找元素
                do{
                    if (e.h == hash &&
                            (((k = e.key) == key) || (key !=null && key.equals(k))))
                        return e;
                }while ((e = e.next) != null);
            }



        }

        return null;
    }


    /**
     * map中是否有这个 键
     * @param key
     * @return false or true
     */
    public boolean containsKey(Object key){
        return getNode(hash(key),key) != null;
    }
    private Entry newEntry(int hash, Object key, Object value, Entry entry) {
        return new Entry(hash,key,value,entry);
    }

    /**
     * 扩容函数
     *   使用情景: 1.初始化数组table，
     *           2.++size>threshold.
     * @return 新的数组table
     *         或者是扩容一倍长度超过最大值，返回原来的table数组
     */
    final  Entry[] resize() {
        // 定义旧的数组为 Entry 类型的数组，oldTab
        Entry[] oldTab = table;
        // 如果oldTab==null  则返回 0，否则返回数组大小
        int oldCap = (oldTab==null) ? 0 : oldTab.length;

        int oldThreshold = threshold;

        int newCap,newThreshold=0;

        // 说明已经不是第一次 扩容，那么已经初始化过，容量一定是 2的n次方，所以可以直接位运算
        if(oldCap>0){
            // 如果 原来的数组大小已经大于等于了最大值，那么阈值设置为 Integer的最大值,即不会再进行扩容
            if(oldCap >= MAX_CAPACITY){
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }

            // 因此已经不是第一次扩容，一定是2的n次方
            else if ((newCap = oldCap << 1) < MAX_CAPACITY &&
                      oldCap >= INIT_CAPACITY)

                newThreshold = oldThreshold << 1;

        }
        // 如果oldThreshold > 0,并且oldCap == 0，说明是还没有进行调用resize方法。
        // 说明输入了初始值，且oldThreshold为 比输入值大的最小的2的n次方
        // 那么就把 oldThreshold 的值赋给 newCap ，因为这个值现在为 比输入值大的最小的2的n次方
        else if(oldThreshold>0)
            newCap = oldThreshold;

        // 这个是只有使用无参构造器的时候才能满足的条件。，全部是否默认的值
        else{
            newCap = INIT_CAPACITY;
            newThreshold = (int) (INIT_CAPACITY * DEFAULT_LOADFACTOR);
        }

        //
        if(newThreshold == 0){

            float ft = (float) (newCap * loadFactor);
            newThreshold =(newCap < MAX_CAPACITY && ft < (float) MAX_CAPACITY ?
                    (int )ft : Integer.MAX_VALUE);
        }

        threshold = newThreshold;

        Entry newTable[] = new Entry[newCap];
        table=newTable;

        // 将原来数组中的所有元素都 copy进新的数组
        if(oldTab != null){
            for (int j = 0; j < oldCap; j++) {
                Entry e;

                if((e = oldTab[j]) != null){
                    oldTab[j] = null;

                    // 说明还没有成链，数组上只有一个
                    if(e.next == null){
                        // 重新计算 数组索引 值
                        newTable[e.h & (newCap-1)] = e;

                    }
                    // 判断是否为树结构
                    //else if (e instanceof TreeNode)


                    // 如果不是树，只是链表,即长度还没有大于 8 进化成树
                    else{
                        // 扩容后，如果元素的 index 还是原来的。就使用这个lo前缀的
                        Entry loHead=null, loTail =null;

                        // 扩容后  元素index改变，那么就使用 hi前缀开头的
                        Entry hiHead = null, hiTail = null;
                        Entry next;
                        do {
                            next = e.next;
                            //这个非常重要，也比较难懂，
                            // 将它和原来的长度进行相与，就是判断他的原来的hash的上一个	bit 位是否为 1。
                            //以此来判断他是在相同的索引还是table长度加上原来的索引
                            if((e.h & oldCap) == 0){
                                // 如果 loTail == null ,说明这个 位置上是第一次添加，没有哈希冲突
                                if(loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else{
                                if(hiTail == null)
                                    loHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e ;
                            }

                        }while ((e = next) != null);


                        if(loTail != null){
                            loTail.next = null;
                            newTable[j] = loHead;
                        }

                        // 新的index 等于原来的 index+oldCap
                        else {

                            hiTail.next = null;
                            newTable[j+oldCap] = hiHead;
                        }

                    }
                }

            }
        }

        return newTable;
    }






}
