#include <stdio.h>      /* for printf() and fprintf() */
#include <sys/socket.h> /* for socket(), connect(), sendto(), and recvfrom() */
#include <arpa/inet.h>  /* for sockaddr_in and inet_addr() */
#include <stdlib.h>     /* for atoi() and exit() */
#include <string.h>     /* for memset() */
#include <unistd.h>     /* for close() */

#include "header.h"

#define ECHOMAX 255     /* Longest string to echo */

void DieWithError(char *errorMessage);  /* External error handling function */

int main(int argc, char *argv[]) {
	
	ClientMessage msg;
	ServerMessage serverMsg;
	
    int sock;                        /* Socket descriptor */
    struct sockaddr_in echoServAddr; /* Echo server address */
    struct sockaddr_in fromAddr;     /* Source address of echo */
    unsigned short echoServPort;     /* Echo server port */
    unsigned int fromSize;           /* In-out of address size for recvfrom() */
    char *servIP;                    /* IP address of server */
    char echoBuffer[ECHOMAX+1];      /* Buffer for receiving echoed string */
    int respStringLen;               /* Length of received response */
    
    if ((argc < 2) || (argc > 3)) {  /* Test for correct number of arguments */
        fprintf(stderr,"Usage: %s <Server IP> [<Echo Port>]\n", argv[0]);
        exit(1);
    }
    
    servIP = argv[1];           /* First arg: server IP address (dotted quad) */
   
    
    if ((sizeof(msg)) > ECHOMAX)  /* Check input length */
        DieWithError("Echo word too long");
    
    if (argc == 3)
        echoServPort = atoi(argv[2]);  /* Use given port, if any */
    else
        echoServPort = 7;  /* 7 is the well-known port for the echo service */
    
    /* Create a datagram/UDP socket */
    if ((sock = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0)
        DieWithError("socket() failed");
	
	/* Construct the server address structure */
    memset(&echoServAddr, 0, sizeof(echoServAddr));    /* Zero out structure */
    echoServAddr.sin_family = AF_INET;                 /* Internet addr family */
    echoServAddr.sin_addr.s_addr = inet_addr(servIP);  /* Server IP address */
    echoServAddr.sin_port   = htons(echoServPort);     /* Server port */
    
	int option;
	char isbn[13] = "\0";
	

	while(1) {
		
		printf("\n====================Book Loan Manager System==========================\n");
		printf("\n======================================================================\n");
		printf("\nPlease select following options to continue: \n");
		printf("1) Query\n");
		printf("2) Borrow\n");
		printf("3) Return\n");
		do {
			printf("\nEnter a valid a option: ");
			scanf("%d", &option);
		}
		while (option < 1 && option > 3);		
		printf("\n=======================================================================\n");

		switch (option)
		{
			case 1:// Query
				printf("\nPlease enter the ISBN number of the book to QUERY: ");
				scanf("%s", isbn);
				memset(&msg, 0, sizeof(msg));
				msg.requestID = rand() % 100 + 1;
				msg.requestType = Query;
				memcpy(msg.isbn, isbn, strlen(isbn));
				/*send query message to server*/
				sendto(sock, &msg, sizeof(msg), 0, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr));
				/*receive response from server*/
				recvfrom(sock, &serverMsg, ECHOMAX, 0,(struct sockaddr*) &fromAddr, &fromSize);

				if (serverMsg.requestID == msg.requestID && serverMsg.respType == Okay) {
					printf("\nPLEASE FIND THE DETAILS OF REQUESTED BOOK: \n");
					printf("ISBN : %s\n", serverMsg.isbn);
					printf("Title : %s\n", serverMsg.title);
					printf("Author(s) : %s\n", serverMsg.authors);
					printf("Edition : %d\n", serverMsg.edition);
					printf("Year Published : %d\n", serverMsg.year);
					printf("Publisher : %s\n", serverMsg.publisher);
					printf("Available : %d\n", serverMsg.available);
					printf("Inventory Count : %d\n", serverMsg.inventory);
				}
				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == ISBNError) {
					printf("\nISBN ERROR: INVALID ISBN \n");
				}

				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == NoInventory) {
					printf("\nSORRY, NO INVENTORY FOR REQUESTED BOOK\n");
				}
				else {
					printf("\nINVALID RESPONSE FROM SERVER !!!\n");
				}
				continue;

			case 2: // Borrow
				printf("\nPlease enter the ISBN number of the book to CHECKOUT: ");
				scanf("%s", isbn);
				msg.requestID = rand() % 100 + 1;
				msg.requestType = Borrow;
				memcpy(msg.isbn, isbn, strlen(isbn));
				/*send query message to server*/
				sendto(sock, &msg, sizeof(msg), 0, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr));
				/*receive response from server*/
				recvfrom(sock, &serverMsg, ECHOMAX, 0, (struct sockaddr*) &fromAddr, &fromSize);
				if (serverMsg.requestID == msg.requestID && serverMsg.respType == Okay) {
					printf("\nREQUESTED BOOK IS CHECKED OUT.\n");
				}
				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == ISBNError) {
					printf("\nISBN ERROR: INVALID ISBN \n");
				}
				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == AllGone) {
					printf("\nREQUESTED BOOK IS NOT AVAILABLE.\n");
				}

				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == NoInventory) {
					printf("\nNO INVENTORY FOR REQUESTED BOOK\n");
				}
				else {
					printf("\nINVALID RESPONSE FROM SERVER\n");
				}
				continue;

			case 3:// Return
				printf("\nPlease enter the ISBN number of the book to RETURN: ");
				scanf("%s", isbn);
				msg.requestID = rand() % 100 + 1;
				msg.requestType = Return;
				memcpy(msg.isbn, isbn, strlen(isbn));

				/*send query message to server*/
				sendto(sock, &msg, sizeof(msg), 0, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr));
				/*receive response from server*/
				recvfrom(sock, &serverMsg, ECHOMAX, 0,(struct sockaddr*) &fromAddr, &fromSize);

				if (serverMsg.requestID == msg.requestID && serverMsg.respType == Okay) {
					printf("\nREQUESTED BOOK HAS BEEN RETURNED.\n", isbn);
				}
				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == ISBNError) {
					printf("\nISBN ERROR: INVALID ISBN\n");
				}
				else if (serverMsg.requestID == msg.requestID && serverMsg.respType == NoInventory) {
					printf("\nINVENTORY IS FULL.\n");
				}
				else {
					printf("\nINVALID RESPONSE FROM SERVER\n");
				}
				continue;
			default:
				break;
		}
 
	    /* Send the string to the server */
	    if (sendto(sock, &msg, sizeof(msg), 0, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr)) != sizeof(msg))
	        DieWithError("sendto() sent a different number of bytes than expected");
	    
	    /* Recv a response */
	    fromSize = sizeof(fromAddr);
	    if ((respStringLen = recvfrom(sock, echoBuffer, ECHOMAX, 0,
	         (struct sockaddr*) &fromAddr, &fromSize)) != sizeof(msg))
	        DieWithError("recvfrom() failed");
	    
	    if (echoServAddr.sin_addr.s_addr != fromAddr.sin_addr.s_addr) {
	        fprintf(stderr,"Error: received a packet from unknown source.\n");
	        exit(1);
	    }
	
	}
	
    /* null-terminate the received data */
    echoBuffer[respStringLen] = '\0';
    printf("Received: %s\n", echoBuffer);    /* Print the echoed arg */
    
    close(sock);
    exit(0);
	}


