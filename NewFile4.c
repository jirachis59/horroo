//2,write aprogram togerate 
//the sum of the frist 100 whole number
#include<stdio.h>
void main()
{
	int i=0,sum=0;
	while (i<=50)
	{
		sum=sum+i;
		i++;
	}
	printf("sum=%d\n",sum);
}