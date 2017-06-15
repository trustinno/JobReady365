package com.goldenictsolutions.win.jobready365_.employer.Empr_datastore;

/**
 * Created by zarni on 5/30/17.
 */

public class Empr_Getter {
    private  int gra;
    private  int accomo;
    private  int sing;
    private int tran;
    private int fod;
    private int train;
    private String empr_compid;
    private  int switchto;


    public void setGra(int grad){
        gra=grad;
    }

    public void setAccomo(int accomod)
    {
        accomo=accomod;
    }
    public  void setSing(int singl)
    {
        sing=singl;
    }

    public void setTran(int trasport)
    {
        tran=trasport;
    }

    public void setFod(int food)
    {
        fod=food;
    }

    public void setTrain(int traning )
    {
        train=traning;

    }
    public void setEmpr_compid(String empr_Compid)
    {
        empr_compid=empr_Compid;
    }


        public void setSwitchto(int switchto_id){
            switchto=switchto_id;
        }
        public int getSwitchto(){
            return switchto;
        }


    public int getGra(){
        return gra;
    }

    public  int getAccomo()
    {
        return  accomo;
    }
    public int getSing()
    {
        return sing;
    }
    public int getTran()
    {
        return tran;
    }
    public int getFod()
    {
        return fod;
    }
    public int getTrain()
    {
        return train;
    }
    public String getEmpr_compid(){
        return empr_compid;
    }
}
