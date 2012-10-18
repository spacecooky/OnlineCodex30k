package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTyrantenwache extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;

	public TYTyrantenwache() {
		name = "Tyrantenwache";
		grundkosten = 0;
		this.setEintragsCNT(0);

		BuildaHQ.addToInformationVector("TYWachen", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tyrantenwache", "Tyrantenwachen", 1, 3, 60);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYTyrantenwache.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tentakelpeitschen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Hornschwerter", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected())
			o1.setSelected(0, true);

		o1.setPreis(1, squad.getModelle() * 5);
		o1.setPreis(2, squad.getModelle() * 15);

		int tyranten = BuildaHQ.getCountFromInformationVector("TYTyrant");
		int wachen = BuildaHQ.getCountFromInformationVector("TYWachen");
		if(wachen > tyranten) {
			setFehlermeldung("Max. " + tyranten + " Einheiten");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TYWachen", -1);
	}

}
