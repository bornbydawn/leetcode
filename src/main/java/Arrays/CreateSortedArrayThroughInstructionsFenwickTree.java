package Arrays;

public class CreateSortedArrayThroughInstructionsFenwickTree {

    int getSum(int index,int BITree[])
    {
        int sum = 0;
        index = index + 1;
        while(index>0)
        {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }
    void updateBIT(int index, int BITree[])
    {
        index = index + 1;
        while(index <= 100001)
        {
            BITree[index] += 1;
            index += index & (-index);
        }
    }

    public static void main(String[] args) {

        CreateSortedArrayThroughInstructionsFenwickTree object = new CreateSortedArrayThroughInstructionsFenwickTree();
        //int[] ins = new int[]{1,3,3,3,2,4,2,1,2};


        //int[] ins = new int[]{1,2,3,3, 4,3};
        //int[] ins = new int[]{1,2,3,3, 4,3};
        //int[] ins = new int[]{1,2,3,6,5,4};
        //int[] ins = new int[]{1,5,6,2};
        int[] ins = new int[]{1,2,3,6,5,4};
        System.out.println(object.createSortedArray(ins));
    }


    public int createSortedArray(int[] instructions) {
        if (instructions.length == 1) return 0;
        int cost = 0;

        int BITree[] = new int[100002];

        for(int i = 0; i < instructions.length; i++){

            cost += Math.min(getSum(instructions[i] - 1, BITree), i - getSum(instructions[i], BITree));
            updateBIT(instructions[i], BITree);
            cost = cost % 1000000007;
        }
        return cost;
    }
}
