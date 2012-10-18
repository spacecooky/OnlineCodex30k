package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class OGOger extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe2, oeM, oeS, oeC;
	
	public OGOger() {
		name = BuildaHQ.translate("Oger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Oger"), 3, 100, 30);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 1));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Handwaffe & Eisenfaust"), 2));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(0, squad.getModelle() * 1);
		o1.setPreis(1, squad.getModelle() * 2);
		
		oe2.setAktiv(oeS.isSelected());
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
