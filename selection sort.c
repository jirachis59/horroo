#include<stdio.h>
 void insertionSort(int arr[],int n)
{
	int i,j, temp;
	// isertion sroting
	
	for(i=1;i<n;i++){
		j=i;
	while(j> 0 && arr[j] <arr[j-1])
		/*swap if the present number less than the previous
	and in asending order  */
	{
		temp=arr[j];
		arr[j]=arr[j-1];
		arr[j-1]=temp;
		j--;
	}	
	}
	}
	void printArray(int arr[],int n)
	{
		int i;
		printf("\n\nSorted Array\n");
		for(i=0;i<n; i++)
			printf("%d\n",arr[i]);
		printf("\n");
		
}
int main()
{
	int k;
	int arr[]={12,11,13,5,6};
	int n=5;
	//int n=sizeof(arr)/sizeof(arr[0]);
	printf("unsorted array:\n");
	for(k=0;k<n; k++){
		printf("%d\t",arr[k]);
}
insertionSort(arr,n);
printArray(arr,n); 
return 0;
}