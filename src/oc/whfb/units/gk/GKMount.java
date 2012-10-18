package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class GKMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	private boolean sphynx = false;

	public GKMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Gruftkönig / Gruftprinz
		// defaults[1] = Hohenpriester des Todes 
		// defaults[2] = Gruftherold
		// defaults[3] = Priester des Todes
		
		sphynx = defaults[0];

		if(defaults[1] || defaults[2] || defaults[3])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skelettpferd"), defaults[1] ? 15 : 10));
		if(defaults[0] || defaults[2]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitwagen"), 55));
		if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Khemrische Kriegssphinx"), 210));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift("Reittiere");
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
		
		if (sphynx) {
			seperator();
			
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftstachel"), 10));
			add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Flammendes Brüllen"), 20));
		}
	}

	@Override
	public void refreshen() {
		if (sphynx) {
			oe1.setAktiv(o1.isSelected(BuildaHQ.translate("Khemrische Kriegssphinx")));
			oe2.setAktiv(o1.isSelected(BuildaHQ.translate("Khemrische Kriegssphinx")));	
		}
	}


}
