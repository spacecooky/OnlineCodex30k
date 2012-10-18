package oc.wh40k.units.dm;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class DMPainBoss extends Eintrag {

    OptionsEinzelUpgrade CyborkKörpa;
    OptionsEinzelUpgrade Panzarüstung;
    OptionsEinzelUpgrade Trophäenstange;
    OptionsEinzelUpgrade Schnappasquik;
    OptionsUpgradeGruppe PainBossCC;
    OptionsEinzelZaehler Schmiergrot;

    public DMPainBoss() {
        kategorie = 1;
        name = "Pain Boss";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power klaw", 25));
        ogE.addElement(new OptionsGruppeEintrag("Big Choppa", 5));

        PainBossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(PainBossCC);

        seperator(15);

        CyborkKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork Body", 10);
        add(CyborkKörpa);

        Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Eavy Armour", 5);
        add(Panzarüstung);

        Trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Pole", 5);
        add(Trophäenstange);

        Schnappasquik = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack Squig", 15);
        add(Schnappasquik);

        seperator();

        Schmiergrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Orderlies", 3, 5);
        add(Schmiergrot);
      
        BuildaHQ.addToInformationVector("DMPainBoss", 1);
        RefreshListener.fireRefresh();
        
        complete();
    }

    @Override
    public void deleteYourself() {
       
        BuildaHQ.addToInformationVector("DMPainBoss", -1);
        RefreshListener.fireRefresh();
        
        super.deleteYourself();
        
    }

    int aktivesBild = 0;

    //@OVERRIDE
    @Override
    public void refreshen() {

        // TODO: "The dok's in"-Regel
    	
    	
            if (aktivesBild != 0) {
                String icon = "oc/wh40k/images/Painboss.gif";

                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                aktivesBild = 0;
            }
        
    }

}
