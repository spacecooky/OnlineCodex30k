package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMMarneusCalgar extends Eintrag {

	public SMMarneusCalgar() {
		name = "Marneus Calgar, Lord Macragge";
		grundkosten = 250;

		BuildaHQ.addToInformationVector("SMEnableHonourGuard", 3);
                
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/MarneusCalgar.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rüstung des Antilochus", 15));

		complete();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
            if(BuildaHQ.getCountFromInformationVector("SMChapterMaster") > 1 && BuildaHQ.getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("SMEnableHonourGuard", -3);
                BuildaHQ.addToInformationVector("SMChapterMaster", -1);
		super.deleteYourself();
	}

}
