package org.cxz.algorithm.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/31 16:00
 */
public class case2166 {

    class Bitset {
        public int base,cnt,_size;
        public int[] bit;
        public Bitset(int size) {
            base = 30;
            _size = size;
            int n = size/base +(size%base==0?0:1);
            bit = new int[n];
        }

        public void fix(int idx) {
            int x = idx/base;
            int y = idx%base;
            if(((bit[x]>>y)&1)==0){
                bit[x] |= (1<<y);//
                cnt++;
            }
            return;
        }

        public void unfix(int idx) {
            int x = idx/base;
            int y = idx%base;
            if(((bit[x]>>y)&1)!=0){
                bit[x] ^= (1<<y);//
                cnt--;
            }
            return;
        }

        public void flip() {
            for(int i=0;i<bit.length;i++){
                bit[i] =~bit[i];
            }
            cnt = _size-cnt;//
            return;
        }

        public boolean all() {
            return count()==_size;
        }

        public boolean one() {
            return cnt>0;
        }

        public int count() {
            return cnt;
        }

        @Override
        public String toString() {
            int n = bit.length;
            int rest = _size%base;
            StringBuffer sb = new StringBuffer();
            for(int i= 0;i<_size/base;i++){
                for(int j = 0;j<base;j++){
                    // int ind = ((bit[i]>>j)&1)==0?0:1;
                    sb.append((((bit[i]>>j)&1)==0?0:1));
                }
            }
            for(int j = 0;j<rest;j++){
                //int ind = (((bit[n-1]>>j)&1)==0?0:1);
                sb.append((((bit[n-1]>>j)&1)==0?0:1));
            }
            return sb.toString();
        }
    }
}
