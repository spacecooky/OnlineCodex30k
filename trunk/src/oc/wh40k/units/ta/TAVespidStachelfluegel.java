package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TAVespidStachelfluegel extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade boss;

	public TAVespidStachelfluegel() {
		name = "Vespid Stachelflügel";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vespid-Stachelflügel", 3, 10, 16);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/VespidStachelfluegel.gif"));
		

		seperator();

		add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schwarmführerin", 22));

		complete();
	}

    @Override
	public void refreshen() {
		boss.setSelected(true);
        
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova) setFehlermeldung("Nicht erlaubt!");
        else setFehlermeldung("");
	}
    
}
