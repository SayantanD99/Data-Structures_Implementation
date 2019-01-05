import java.util.Scanner;
class Stack{
    int arr[]=new int[100];
    int top;
    Stack()
    {
        top=-1;
    }
    void push(int data,int nod){
        if(top==nod-1)
            System.out.println("\nStack Overflowing !!");
        else
            arr[++top]=data;
    }
    void pop(){
        if(top==-1){
            System.out.println("\nStack Underflowing !!");
                         }
        else
            System.out.println("Item Popped = "+arr[top--]);

    }
    void display(int nod){
        System.out.println("\nStack Contents : ");
        for(int i=0;i<nod;i++)
            System.out.println(arr[i]);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Stack obj = new Stack();
        int n,data,ch;
        System.out.println("Enter the Stack Size : ");
        n=sc.nextInt();
        do{
            System.out.println("Choose : \n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. exit");
            System.out.println("Enter Your Choice : ");
            ch=sc.nextInt();
            switch (ch){
                case 1 :
                    System.out.println("Enter the Element to be Inserted : ");
                    data=sc.nextInt();
                    obj.push(data,n);
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.display(n);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choice not Valid !!");
                    continue;
            }
        }while(true);
    }
}
