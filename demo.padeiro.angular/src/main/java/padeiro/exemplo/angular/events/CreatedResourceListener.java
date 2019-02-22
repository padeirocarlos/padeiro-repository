package padeiro.exemplo.angular.events;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

	@Override
	public void onApplicationEvent(CreatedResourceEvent event) {

		HttpServletResponse response = event.getResponse();

		Long codigo = event.getId();

		addHeaderLocation(response, codigo, event.getIsCode());

	}

	private void addHeaderLocation(HttpServletResponse response, Long codigo, boolean iscode) {

		if (iscode) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo)
					.toUri();
			response.setHeader("Location", uri.toASCIIString());
		} else {

			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(codigo).toUri();
			response.setHeader("Location", uri.toASCIIString());
		}
	}
}
