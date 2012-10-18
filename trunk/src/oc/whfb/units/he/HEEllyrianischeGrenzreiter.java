package oc.whfb.units.he;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class HEEllyrianischeGrenzreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public HEEllyrianischeGrenzreiter() {
		name = BuildaHQ.translate("Ellyrianische Grenzreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ellyrianische Grenzreiter"), 5, 100, 17);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/HEEllyrianischeGrenzreiter.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speere"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bögen"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speere") + " & " + BuildaHQ.translate("Bögen"), 4));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 7));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 14));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 7));

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
		o1.setPreis(1, squad.getModelle() * 2);
		o1.setPreis(2, squad.getModelle() * 4);
	}
}
