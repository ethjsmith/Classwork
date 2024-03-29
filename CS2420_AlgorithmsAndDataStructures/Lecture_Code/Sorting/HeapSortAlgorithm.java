/*
 * @(#)HeapSortAlgorithm.java	1.0 95/06/23 Jason Harrison
 *
 * Copyright (c) 1995 University of British Columbia
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * UBC MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UBC SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * A heap sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author Jason Harrison@cs.ubc.ca
 * @version 	1.0, 23 Jun 1995
 */
class HeapSortAlgorithm extends SortAlgorithm {
    void sort(int a[]) throws Exception {
	int N = a.length;
	for (int k = N/2; k > 0; k--) {
	    downheap(a, k, N);
	    pause();
        }
	do {
            int T = a[0];
            a[0] = a[N - 1];
            a[N - 1] = T;
	    N = N - 1;
	    pause(N);
            downheap(a, 1, N);
	} while (N > 1);
    }

    void downheap(int a[], int k, int N) throws Exception {
	int T = a[k - 1];
	while (k <= N/2) {
            int j = k + k;
            if ((j < N) && (a[j - 1] < a[j])) {
	        j++;
	    }
	    if (T >= a[j - 1]) {
		break;
	    } else {
                a[k - 1] = a[j - 1];
                k = j;
		pause();
            }
	}
        a[k - 1] = T;
	pause();
    }
}

