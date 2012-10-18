package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.whfb.armies.VOLKOgerAB2004;

public class OG2004Ogerbullen extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	boolean set = false;

	public OG2004Ogerbullen() {
		name = BuildaHQ.translate("Ogerbullen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ogerbullen"), 3, 100, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGOgerbullen.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Handwaffe & Eisenfaust"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 3));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 3);
		o1.setPreis(0, squad.getModelle() * 4);
		o1.setPreis(1, squad.getModelle() * 5);
		oe2.setAktiv(oeS.isSelected());
		
		if(!set){
			VOLKOgerAB2004.OGERBULLEN ++;
			set = true;
		}
	}

	@Override
	public void deleteYourself() {
		VOLKOgerAB2004.OGERBULLEN --;
		super.deleteYourself();
	}

}
