class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        ArrayList<Integer> li = new ArrayList<>();
        int ctr = 0;

        if (s1.equals(s2))
            return true;

        else {

            for (int i = 0; i < s1.length() && ctr <= 2; i++) {

                if (s1.charAt(i) != s2.charAt(i) && ctr <= 2) {
                    li.add(i);
                    ctr++;
                }

            }

            char[] ch = s1.toCharArray();
            if (ctr == 2) {

                char temp = ch[(li.get(0))];
                ch[(li.get(0))] = ch[(li.get(1))];
                ch[(li.get(1))] = temp;
            }
            String st = new String(ch);
            if (st.equals(s2))
                return true;

        }

    }
}
