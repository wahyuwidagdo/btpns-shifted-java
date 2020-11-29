package com.codeflex.springboot.model;

abstract public class Worker {

        public long id;

        public String name;

        public int tunjanganPulsa = 100000, gajiPokok = 5000000, absensi = 20;

        public abstract long getId();

        public abstract void setId(long id);

        public abstract String getName();

        public abstract void setName(String name);

        public abstract int getTunjanganPulsa();

        public abstract void setTunjanganPulsa(int tunjanganPulsa);

        public abstract int getGajiPokok();

        public abstract void setGajiPokok(int gajiPokok);

        public abstract int getAbsensi();

        public abstract void tambahAbsensi();

}
