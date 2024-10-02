import http.server
import ssl

portnum = 443
ipaddress = '0.0.0.0'
server_address = (ipaddress, portnum)

# Create HTTP server instance
httpd = http.server.HTTPServer(server_address, http.server.SimpleHTTPRequestHandler)

# Create SSL context (default to most secure settings)
context = ssl.SSLContext(ssl.PROTOCOL_TLS_SERVER)
context.load_cert_chain(certfile='a.pem')

# Wrap the HTTP server's socket with SSL
httpd.socket = context.wrap_socket(httpd.socket, server_side=True)

print(f"Starting HTTPS server on {ipaddress} port {portnum}")

# Serve requests
httpd.serve_forever()
