public class IntArrayMethods{
    public static int arraySum(int[] a){
        int sum = 0;
        for(int val:a){
            sum += val;
        }
        return sum;
    }

    public static double arrayMean(int[] a){
        return (double)arraySum(a)/a.length;
    }

    public static int arrayMin(int[] a){
        int min = a[0];
        for(int val:a){
            if(val<min){min = val;}
        }
        return min;
    }

    public static int arrayMax(int[] a){
        int max = a[0];
        for(int val:a){
            if(val>max){max = val;}
        }
        return max;  
    }

    public static boolean[] arrayLocalMax(int[] a){
        boolean[] maxs = new boolean[a.length];
        //check beginning
        maxs[0] = a[0] > a[1];

        //check everything in the middle
        for(int i=1;i<a.length-1;i++){
            maxs[i] = a[i] > a[i-1] && a[i] > a[i+1];
        }

        //check end
        maxs[a.length-1] = a[a.length-1] > a[a.length-2];
        return maxs;
    }

    public static boolean[] arrayLocalMin(int[] a){
        boolean[] mins = new boolean[a.length];
        //check beginning
        mins[0] = a[0] < a[1];

        //check everything in the middle
        for(int i=1;i<a.length-1;i++){
            mins[i] = a[i] < a[i-1] && a[i] < a[i+1];
        }

        //check end
        mins[a.length-1] = a[a.length-1] < a[a.length-2];
        return mins;
    }

    public static int arrayMode(int[] a){
        int mode = a[0];
        int maxcount = 0;
        for(int i:a){
            int count = 0; // account for counting self as a match
            for(int j:a){
                if(i==j){
                    count++;
                }
            }
            if(count>maxcount){
                mode = i;
                maxcount = count;
            }
        }
        return mode;
    }

    public static int arrayCount(int[] a, int b){
        int count = 0;
        for(int i:a){
            if(i==b){
                count++;
            }
        }
        return count;
    }

    public static boolean arrayContainsDuplicates(int[] a){
        for(int i:a){
            int count = 0; // account for counting self as a match
            for(int j:a){
                if(i==j){
                    count++;
                    if(count>1){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean arrayAllEqual(int[] a){
        int prev = a[0];
        for(int i:a){
            if(i!=prev){
                return false;
            }
            prev = i;
        }
        return true;
    }

    public static double[] arrayRollingAverage(int[] a, int b){
        double[] avgs = new double[a.length];
        for(int i=0;i<a.length;i++){
            int start;
            if(b>i){
                start = 0;
            }else{
                start = i - b + 1;
            }
            int sum = 0;
            for(int j=start;j<=i;j++){
                sum += a[j];
            }
            avgs[i] = (double)sum/(i-start+1);
        }
        return avgs;
    }

    public static int[] arrayShift(int[] a, int b){
        int[] out = new int[a.length];
        for(int i=0;i<a.length;i++){
            int index;
            if(i+b>=a.length){
                index = i+b-a.length;
            }else{
                index = i+b;
            }

            out[index] = a[i];
        }
        return out;
    }

    public static int[] arrayReverse(int[] a){
        int[] out = new int[a.length];
        for(int i=0;i<a.length;i++){
            out[i] = a[a.length-1-i];
        }
        return out;
    }
}