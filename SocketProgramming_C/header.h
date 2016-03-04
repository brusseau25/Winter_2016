typedef struct {

	unsigned int requestID; /* unique client identifier */
	enum {Query, Borrow, Return} requestType; /* same size as an unsigned int*/
	char isbn[13]; /* book’s validated ISBN-13*/
} ClientMessage;

typedef struct {

	unsigned int requestID; 				/*unique client id*/
	enum {Okay, ISBNError, AllGone, NoInventory} respType;  /*size as an unsigned int */
	char isbn[13];  					/*book ISBN-13*/
	char authors[100]; 					/*book author(s)*/
	char title[100];					/*book title*/
	unsigned int edition;					/*book edition*/
	unsigned int year;					/*book publication year*/
	char publisher[100];					/*book author(s)*/
	unsigned int inventory;					/*book count*/
	unsigned int available;					/*# of available books*/
} ServerMessage;


int validateISBN(char isbn[])
{
	long checksum = 0;
	int i, mul = 1, sum = 0, m10, j;

	int len = strlen(isbn);
	if(len != 13)
		return -1;

	for(i=0; i<len-1; i++)
	{
		char c = isbn[i];
		int val = atoi(&c);
		sum += val * mul;
	    if(mul==3)
	    	mul=1;
	    else
	    	mul = 3;
	}
	m10 = sum%10;

	char checkDigit = isbn[len - 1];
	checksum = atoi(&checkDigit);

	int sub = 10 - m10;
	if (m10 == 0)
		sub = 0;

	if(sub == checksum)
		return 1;
	else
		return 0;
}


void setStruct(){
ServerMessage record[30];
	FILE * file;
	char line[256];

	char *item;
	int count = 0;
	int k;

	file = fopen("Books.txt","r");
	/* Read file line by line */

	while (fgets(line,255,file)) {
			printf("%s",line);
			
			item = strtok(line,",");
			strcpy(record[count].isbn, item);

			item = strtok(NULL,",");
			strcpy(record[count].authors, item);

			item = strtok(NULL,",");
			strcpy(record[count].title,item);

			item = strtok(NULL,",");
			record[count].edition = atoi(item);
			
			item = strtok(NULL,",");
			record[count].year = atoi(item);

			item = strtok(NULL,",");
			strcpy(record[count].publisher,item);
			
			item = strtok(NULL,",");
			record[count].inventory = atoi(item);

			item = strtok(NULL,"\n");
			record[count].available = atoi(item);

			printf("\n%s\n"," ");
			count++;
	}

	fclose(file);
}
	
