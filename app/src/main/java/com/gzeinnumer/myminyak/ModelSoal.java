package com.gzeinnumer.myminyak;

class ModelSoal {
    int no;
    String soal, a,b,c,d;
    String jawaban;

    public ModelSoal(int no, String soal, String a, String b, String c, String d, String jawaban) {
        this.no = no;
        this.soal = soal;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.jawaban = jawaban;
    }

    public int getNo() {
        return no;
    }

    public String getSoal() {
        return soal;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getJawaban() {
        return jawaban;
    }
}
