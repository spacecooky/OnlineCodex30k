package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BATerminatorSturmtrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkTransport;

	public BATerminatorSturmtrupp() {
		name = "Terminator-Sturmtrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sturm-Terminatoren", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BATerminatorSturmtrupp.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("E-Hammer & Schild", "Energiehammer & Sturmschild", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(false, false, true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
