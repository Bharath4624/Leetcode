class Solution {
	public static String minRemoveToMakeValid(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		int balance = 0;
		int minBalance = 0;
		for (int i = 0; i < n; i++)
			switch (chars[i]) {
				case '(':
					balance++;
					break;
				case ')':
					if (--balance < minBalance)
						minBalance = balance;
					break;
			}
		int removeHead = -minBalance;
		int removeTail = balance - minBalance;
		char[] valid = new char[n - removeHead - removeTail];
		int ih = 0;
		int jh = 0;
		while (removeHead > 0) {
			char c = chars[ih++];
			if (c == ')')
				removeHead--;
			else
				valid[jh++] = c;
		}
		int it = n;
		int jt = valid.length;
		while (removeTail > 0) {
			char c = chars[--it];
			if (c == '(')
				removeTail--;
			else
				valid[--jt] = c;
		}
		System.arraycopy(chars, ih, valid, jh, jt - jh);
		return new String(valid);
	}
}