package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class VFKraft extends RuestkammerVater {

	OptionsEinzelUpgrade[] o = new OptionsEinzelUpgrade[18];

	private int maxCosts = 50;

	public VFKraft() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		if(defaults[0]) maxCosts = 100;

		add(o[0] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spektrale Gestalt"), 50));
		add(o[1] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Herr der Ghule"), 25));
		add(o[2] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Übernatürlicher Schrecken"), 25));

		seperator();

		add(o[3] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Meister schwarzer Künste"), BuildaHQ.translate("Meister der schwarzen Künste"), 50));
		add(o[4] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Verbotenes Wissen"), 35));
		add(o[5] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Dunkler Akolyth"), 30));

		seperator();

		add(o[6] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fliegender Schrecken"), 30));
		add(o[7] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Unendlicher Hass"), 25));
		add(o[8] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Jäger der Finsternis"), 25));
		
		seperator();
		
		add(o[9] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Rote Wut"), 50));
		add(o[10] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Avatar des Todes"), 20));
		add(o[11] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Ritter der Nacht"), 25));

		seperator();

		add(o[12] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Aura finsterer Erhabenheit"), 50));
		add(o[13] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wandelnder Tod"), 25));
		add(o[14] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Bezauberndes Wesen"), 25));

		seperator();

		add(o[15] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Herrscher der Toten"), 15));
		add(o[16] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Nachtkreaturen herbeirufen"), BuildaHQ.translate("Kreaturen der Nacht herbeirufen"), 15));
		add(o[17] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Ghule herbeirufen"), 15));
		setUeberschrift(BuildaHQ.translate("Vampir Kräfte"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);

	}

	@Override
	public void refreshen() {

		double totalCosts = 0;
		for(int i=0; i<o.length; i++) {
			if(o[i] == null) continue;
			totalCosts += o[i].getKosten();
		}

		if(totalCosts > this.maxCosts) {
			setButtonState(false);
			showErrorMessage("Max. " + this.maxCosts + " "+BuildaHQ.translate("Punkte"));
		} else {
			setButtonState(true);
			hideErrorMessage();
			showErrorMessage( entferneNullNachkomma(totalCosts) + " / " + maxCosts + " " + BuildaHQ.translate("Punkte"));
		}
	}

	@Override
	public Object getSpecialValue() {
		if (o[0].isSelected() && !o[11].isSelected()) return (BuildaHQ.translate("Spektrale Gestalt"));
		if (!o[0].isSelected() && o[11].isSelected()) return (BuildaHQ.translate("Ritter der Nacht"));
		if (o[0].isSelected() && o[11].isSelected()) return (BuildaHQ.translate("beides"));
		else return ("");
	}
	
	public boolean getWissen() {
        return o[4].isSelected();
    }
	
	public boolean getAvatar() {
        return o[10].isSelected();
    }
	
	public void setRoteWut(boolean wut){
		o[9].setAktiv(wut);
	}
	
	public boolean getRoteWut() {
        return o[9].isSelected();
    }
}